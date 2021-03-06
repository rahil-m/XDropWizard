/**
 * Copyright 2015-2018 Knowm Inc. (http://knowm.org) and contributors.
 * Copyright 2013-2015 Xeiam LLC (http://xeiam.com) and contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.knowm.xdropwizard.jobs;

import org.knowm.sundial.Job;
import org.knowm.sundial.JobContext;
import org.knowm.sundial.exceptions.JobInterruptException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author timmolter
 */
public class SampleJob3 extends Job {

  private final Logger logger = LoggerFactory.getLogger(SampleJob3.class);

  @Override public void doRun() throws JobInterruptException {

    JobContext context = getJobContext();

    String valueAsString = context.get("MyParam");
    logger.info("valueAsString = " + valueAsString);

    Integer valueAsInt = Integer.valueOf(valueAsString);
    logger.info("valueAsInt = " + valueAsInt);

    context.put("MyValue", new Integer(123));

    new SampleJobAction().run();

  }
}
