package com.training.learning.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Designate(ocd = ReadJsonFromAPIScheduler.CronExpressionConfiguration.class)
@Component(service = Runnable.class,immediate = true)
public class ReadJsonFromAPIScheduler implements  Runnable{

    @Reference
    Scheduler scheduler;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
   @ObjectClassDefinition(name="Read API Json",description = "Reading")
    public static @interface CronExpressionConfiguration
   {
       @AttributeDefinition(name = "Cron Expression",type = AttributeType.STRING)
       public String getCronExp() default "* * * * * ?";

       @AttributeDefinition(
               name = "Scheduler Name",
               description = "Enter a unique identifier that represents name of the scheduler",
               type = AttributeType.STRING
       )
       public String schedulerName() default "CronExpreesion Configuration";;

   }


    @Activate
    protected void activate(CronExpressionConfiguration configuration) {
        LOGGER.info("{}: initializing properties for scheduler", configuration);
        addScheduler(configuration);
    }

    private void addScheduler( CronExpressionConfiguration configuration) {
        // Check if the scheduler has enable flag set to true

            LOGGER.info("{}: scheduler: {} is enabled");
            // Configure the scheduler to use cron expression and some other properties
            ScheduleOptions scheduleOptions = scheduler.EXPR(configuration.getCronExp());
            scheduleOptions.name(configuration.schedulerName());
            scheduleOptions.canRunConcurrently(false);
            // Scheduling the job
            scheduler.schedule(this, scheduleOptions);
    }

    private void removeScheduler(CronExpressionConfiguration configuration) {
        LOGGER.info("{}: removing scheduler {}", configuration.schedulerName());
        scheduler.unschedule(configuration.schedulerName());
    }
    @Modified
    protected void modified(CronExpressionConfiguration configuration) {
        LOGGER.info("{}: modifying scheduler with name: {}", configuration.schedulerName());
        // Remove the scheduler registered with old configuration
        removeScheduler(configuration);
        // Add the scheduler registered with new configuration
        addScheduler(configuration);
    }

    @Deactivate
    protected void deactivate(CronExpressionConfiguration configuration) {
        LOGGER.info("{}: removing scheduler: {}");
        removeScheduler(configuration);
    }

    @Override
    public void run() {
        LOGGER.info("Calling this Scheduler Every Second");
    }
}
