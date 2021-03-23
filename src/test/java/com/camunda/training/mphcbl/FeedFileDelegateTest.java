package com.camunda.training.mphcbl;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class FeedFileDelegateTest {

	@Mock
	private DelegateExecution delEx;

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private HistoryService hs;

	@InjectMocks
	private FeedFileDelegate ffd;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFeedFileDelegate() throws Exception {

		List<HistoricProcessInstance> hisPI = getHistoricProcessInstances();

		when(hs.createHistoricProcessInstanceQuery()//
				.finishedAfter(any(Date.class))//
				.finishedBefore(any(Date.class)).list())//
						.thenReturn(hisPI);

		when(delEx.getVariable("testVar")).thenReturn("testValue");
		
		ffd.execute(delEx);
		
		verify(delEx).setVariable("testVar", "testValueChanged");

	}

	private List<HistoricProcessInstance> getHistoricProcessInstances() {
		List<HistoricProcessInstance> hisPI = new ArrayList<HistoricProcessInstance>();
		hisPI.add(new HistoricProcessInstance() {

			@Override
			public String getTenantId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getSuperProcessInstanceId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getSuperCaseInstanceId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getState() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getStartUserId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Date getStartTime() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getStartActivityId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getRootProcessInstanceId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Date getRemovalTime() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Integer getProcessDefinitionVersion() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getProcessDefinitionName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getProcessDefinitionKey() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getProcessDefinitionId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getId() {
				// TODO Auto-generated method stub
				return "123";
			}

			@Override
			public Date getEndTime() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getEndActivityId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Long getDurationInMillis() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getDeleteReason() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getCaseInstanceId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getBusinessKey() {
				// TODO Auto-generated method stub
				return null;
			}
		});
		return hisPI;
	}

}
