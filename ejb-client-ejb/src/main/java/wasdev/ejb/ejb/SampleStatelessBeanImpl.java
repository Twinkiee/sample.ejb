/*******************************************************************************
 * (c) Copyright IBM Corporation 2017.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package wasdev.ejb.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;
import wasdev.ejb.api.SampleStatelessBean;

/**
 * _@Local(SampleStatelessBean.class) must be used when multiple interfaces are implemented<br>
 * _@LocalBean Can be used instead of @Local if the local EJB is injected by class and not by
 * implemented interface
 */
@Stateless
// Can be used without indicating a specific interface if only one interface is used
@Local
public class SampleStatelessBeanImpl implements SampleStatelessBean {

  @Override
  public String hello() {
    return "Hello LOCAL EJB World.";
  }
}
