package com.training.learning.core.workflows;

import java.util.Arrays;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(service = WorkflowProcess.class,property = { "process.label=" + "SampleProcess Workflow Example" })
public class SampleWorkflow implements WorkflowProcess{

	 private final Logger logger = LoggerFactory.getLogger(SampleWorkflow.class);
	@Override
	public void execute(WorkItem arg0, WorkflowSession arg1, MetaDataMap arg2) throws WorkflowException {
		
		logger.info("i am Inside Workflows");
		
		
		
		WorkflowData workflowData = arg0.getWorkflowData();

        //Getting payload from Workflow
        String payloadType = workflowData.getPayloadType();

        try {
            // Check type of payload; there are two - JCR_PATH and JCR_UUID
            if (StringUtils.equals(payloadType, "JCR_PATH")) {
            	logger.info("Payload type: {}", payloadType);

                Session session = arg1.adaptTo(Session.class);
                // Get the JCR path from the payload
                String path = arg0.getWorkflowData().getPayload().toString();
                logger.info("Payload path: {}", path);

                Node node = (Node) session.getItem(path);
                node.setProperty("xyz","abc");

                //To get the MetaDataMap
                MetaDataMap workFlowMetaDataMap = arg0.getWorkflow().getWorkflowData().getMetaDataMap();

                // Get workflow process arguments
                String[] processArguments = arg2.get("PROCESS_ARGS", "Default").split(",");
                logger.info("Process args: {}", Arrays.toString(processArguments));
            }
        } catch (Exception e) {
        	logger.info("Exception Occurred:{}",e.getMessage());
        }
    	
		logger.info("Complted my Workflow");
		
	}

}
