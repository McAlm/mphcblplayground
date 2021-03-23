package com.camunda.training.mphcbl;

import java.util.Date;
import java.util.List;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeedFileDelegate implements JavaDelegate {

	@Autowired
	private HistoryService hs;

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		String testVar = (String) execution.getVariable("testVar");

		List<HistoricProcessInstance> hisPI = hs.createHistoricProcessInstanceQuery()//
				.finishedAfter(new Date(2021, 3, 23))//
				.finishedBefore(new Date(2021, 3, 22))//
				.list();

		hisPI.forEach(p -> System.out.println(p.getId()));

		execution.setVariable("testVar", testVar.concat("Changed"));

	}

}
