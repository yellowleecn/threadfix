////////////////////////////////////////////////////////////////////////
//
//     Copyright (c) 2009-2013 Denim Group, Ltd.
//
//     The contents of this file are subject to the Mozilla Public License
//     Version 2.0 (the "License"); you may not use this file except in
//     compliance with the License. You may obtain a copy of the License at
//     http://www.mozilla.org/MPL/
//
//     Software distributed under the License is distributed on an "AS IS"
//     basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
//     License for the specific language governing rights and limitations
//     under the License.
//
//     The Original Code is ThreadFix.
//
//     The Initial Developer of the Original Code is Denim Group, Ltd.
//     Portions created by Denim Group, Ltd. are Copyright (C)
//     Denim Group, Ltd. All Rights Reserved.
//
//     Contributor(s): Denim Group, Ltd.
//
////////////////////////////////////////////////////////////////////////
package com.denimgroup.threadfix.importer.dao;

import com.denimgroup.threadfix.data.dao.ApplicationChannelDao;
import com.denimgroup.threadfix.data.entities.ApplicationChannel;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

/**
 * Hibernate Channel DAO implementation. Most basic methods are implemented in
 * the AbstractGenericDao
 * 
 * @author mcollins, dwolf
 * @see AbstractGenericDao
 */
@Repository
public class HibernateApplicationChannelDao implements ApplicationChannelDao {

	private SessionFactory sessionFactory;

	@Autowired
	public HibernateApplicationChannelDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ApplicationChannel> retrieveAll() {
		return getActiveChannelCriteria()
				.createAlias("channelType", "ct")
				.createAlias("application", "app")
				.createAlias("application.organization", "org")
				.addOrder(Order.asc("org.name"))
				.addOrder(Order.asc("app.name"))
				.addOrder(Order.asc("ct.name")).list();
	}

	@Override
	public ApplicationChannel retrieveByAppIdAndChannelId(Integer appId, Integer channelId) {
		return (ApplicationChannel) getActiveChannelCriteria()
				.createAlias("channelType", "ct")
				.createAlias("application", "app")
				.add(Restrictions.eq("ct.id", channelId))
				.add(Restrictions.eq("app.id", appId))
				.uniqueResult();
	}

	@Override
	@Transactional
	public ApplicationChannel retrieveById(int id) {
		return (ApplicationChannel) getActiveChannelCriteria()
				.add(Restrictions.eq("id",id))
				.uniqueResult();
	}
	
	private Criteria getActiveChannelCriteria() {
		return sessionFactory.getCurrentSession()
				   			 .createCriteria(ApplicationChannel.class)
				   			 .add(Restrictions.eq("active", true));
	}

	@Override
	public void saveOrUpdate(ApplicationChannel applicationChannel) {
		sessionFactory.getCurrentSession().saveOrUpdate(applicationChannel);
	}

	@Override
	public Calendar getMostRecentQueueScanTime(Integer channelId) {
		return (Calendar) sessionFactory
				.getCurrentSession()
				.createQuery("select scanDate from JobStatus status " +
							 "where applicationChannel = :channelId and hasStartedProcessing is false " +
							 "order by scanDate desc")
				.setInteger("channelId", channelId).setMaxResults(1).uniqueResult();
	}
}
