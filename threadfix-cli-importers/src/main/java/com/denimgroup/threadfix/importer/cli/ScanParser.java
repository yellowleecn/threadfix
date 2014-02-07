package com.denimgroup.threadfix.importer.cli;

import com.denimgroup.threadfix.data.dao.ChannelTypeDao;
import com.denimgroup.threadfix.data.entities.Scan;
import com.denimgroup.threadfix.data.entities.ScannerType;
import com.denimgroup.threadfix.importer.interop.ScanCheckResultBean;
import com.denimgroup.threadfix.importer.interop.ScanImportStatus;
import com.denimgroup.threadfix.importer.parser.ThreadFixBridge;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileNotFoundException;

@Component
public class ScanParser {

    @Autowired
    ThreadFixBridge bridge;
    @Autowired
    ChannelTypeDao channelTypeDao;

    /**
     *
     * @param filePath path to a file. Will throw exceptions if not valid
     * @return the String output
     */
    @Transactional(readOnly = true)
    public String readFile(@NotNull String filePath) {
        if (bridge == null) {
            throw new IllegalStateException("Spring configuration is broken, please fix autowiring.");
        }
        try {
            return ScanSerializer.toCSVString(getScan(filePath));
        } catch (TypeParsingException e) {
            return "Unable to determine the scan type of the file.";
        } catch (ScanTestingException e) {
            return "Scan check failed and returned the following status: " + e.status;
        } catch (ScanFileNotFoundException e) {
            return "Scan file was not found.";
        }
    }


    @Transactional(readOnly = true)
    public Scan getScan(@NotNull String filePath) throws TypeParsingException, ScanTestingException {
        return getScan(new File(filePath));
    }

    @Transactional(readOnly = true)
    public Scan getScan(@NotNull File file) throws TypeParsingException, ScanTestingException, ScanFileNotFoundException {

        if (!file.exists()) {
            throw new ScanFileNotFoundException("Scan file not found: " + file.getAbsolutePath());
        }

        ScannerType scannerType = bridge.getType(file);

        if (scannerType == null) {
            throw new TypeParsingException();
        } else {
            ScanCheckResultBean resultBean = bridge.testScan(scannerType, file);

            if (resultBean.getScanCheckResult() == ScanImportStatus.SUCCESSFUL_SCAN) {
                return bridge.getScan(scannerType, file);
            } else {
                throw new ScanTestingException(resultBean.getScanCheckResult());
            }
        }
    }

    class ScanFileNotFoundException extends RuntimeException {
        public ScanFileNotFoundException(String message) {
            super(message);
        }
    }
    class TypeParsingException extends RuntimeException {}
    class ScanTestingException extends RuntimeException {
        public final ScanImportStatus status;

        ScanTestingException(ScanImportStatus status) {
            this.status = status;
        }
    }
}
