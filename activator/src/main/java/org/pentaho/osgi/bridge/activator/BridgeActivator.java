/*! ******************************************************************************
 *
 * Pentaho Data Integration
 *
 * Copyright (C) 2002-2015 by Pentaho : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.osgi.bridge.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.pentaho.di.osgi.OSGIActivator;
import org.pentaho.osgi.blueprint.PentahoNamespaceActivator;
import org.pentaho.osgi.bridge.KarafCapabilityProvider;

/**
 * The "Main" Activator for this bundle. Bundles can only have one Activator so this one chains to others as needed.
 * Created by nbaker on 2/13/15.
 */
public class BridgeActivator implements BundleActivator {
  @Override public void start( BundleContext bundleContext ) throws Exception {

    new KarafCapabilityProvider( bundleContext ).open();

    new OSGIActivator().start( bundleContext );
    new PentahoNamespaceActivator().start( bundleContext );
  }

  @Override public void stop( BundleContext bundleContext ) throws Exception {

  }
}
