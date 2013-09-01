# Apache Maven

[Guide to Creating Archetypes](http://maven.apache.org/guides/mini/guide-creating-archetypes.html)

## Install and use archetype

    cd myservice-osgi-template
    mvn install

    mkdir newproject
    cd newproject
    mvn archetype:generate                                  \
      -DarchetypeGroupId=<archetype-groupId>                \
      -DarchetypeArtifactId=<archetype-artifactId>          \
      -DarchetypeVersion=<archetype-version>                \
      -DgroupId=<my.groupid>                                \
      -DartifactId=<my-artifactId>

# OSGi

## Setting up Felix


    g! obr:deploy "Apache Felix File Install"
    g! obr:deploy "Apache Felix Configuration Admin Service"
    g! obr:deploy "OSGi R4 Compendium Bundle"

or

    g! obr:deploy org.apache.felix.fileinstall
    g! obr:deploy org.apache.felix.configadmin
    g! obr:deploy org.osgi.compendium

## Installing bundles

Copy bundles into FELIX_HOME/bundles folder

or

    g! felix:install file:/path/to/myservice-api-1.0-SNAPSHOT.jar
    g! felix:install file:/path/to/myservice-1.0-SNAPSHOT.jar
    g! felix:install file:/path/to/myservice-client-1.0-SNAPSHOT.jar

## Starting OSGi container with installed bundles

    felix-framework-4.0.2 $ java -jar bin/felix.jar
    Dez 23, 2012 4:20:34 PM eu.artofcoding.myservice.impl.MyBundleActivator start
    INFO: Starting bundle eu.artofcoding.myservice.osgi through eu.artofcoding.myservice.impl.MyBundleActivator
    Dez 23, 2012 4:20:34 PM eu.artofcoding.myservice.impl.MyBundleActivator start
    INFO: Bundle eu.artofcoding.myservice.osgi started
    Dez 23, 2012 4:20:34 PM eu.artofcoding.myservice.client.MyBundleActivator start
    INFO: Starting bundle eu.artofcoding.myservice.client
    Dez 23, 2012 4:20:34 PM eu.artofcoding.myservice.impl.MyServiceFactory getService
    INFO: Created new service instance eu.artofcoding.myservice.impl.MyServiceImpl@44cfc00b for bundle=eu.artofcoding.myservice.client
    Hello from eu.artofcoding.myservice.impl.MyServiceImpl@44cfc00b#sayHello(), Justus Jonas
    Dez 23, 2012 4:20:34 PM eu.artofcoding.myservice.client.MyBundleActivator start
    INFO: Bundle eu.artofcoding.myservice.client started
    ____________________________
    Welcome to Apache Felix Gogo

    g!

## Updating bundles

    g! update 36 file:/path/to/myservice-api-1.0-SNAPSHOT.jar

    g! update 37 file:/path/to/myservice-1.0-SNAPSHOT.jar
    Dez 23, 2012 3:48:38 PM eu.artofcoding.myservice.impl.MyBundleActivator stop
    INFO: Stopping bundle eu.artofcoding.myservice.osgi
    Dez 23, 2012 3:48:38 PM eu.artofcoding.myservice.impl.MyBundleActivator stop
    INFO: Bundle eu.artofcoding.myservice.osgi stopped
    Dez 23, 2012 3:48:38 PM eu.artofcoding.myservice.impl.MyBundleActivator start
    INFO: Starting bundle eu.artofcoding.myservice.osgi through eu.artofcoding.myservice.impl.MyBundleActivator
    Dez 23, 2012 3:48:38 PM eu.artofcoding.myservice.impl.MyBundleActivator start
    INFO: Bundle eu.artofcoding.myservice.osgi started

    g! update 40 file:/path/to/myservice-client-1.0-SNAPSHOT.jar
    Dez 23, 2012 3:48:45 PM eu.artofcoding.myservice.client.MyBundleActivator stop
    INFO: Stopping bundle eu.artofcoding.myservice.client
    Dez 23, 2012 3:48:45 PM eu.artofcoding.myservice.client.MyBundleActivator stop
    INFO: Bundle eu.artofcoding.myservice.client stopped
    Dez 23, 2012 3:48:45 PM eu.artofcoding.myservice.client.MyBundleActivator start
    INFO: Starting bundle eu.artofcoding.myservice.client
    Dez 23, 2012 3:48:45 PM eu.artofcoding.myservice.impl.MyServiceFactory getService
    INFO: Created new service instance eu.artofcoding.myservice.impl.MyServiceImpl@2b054ac8 for bundle=eu.artofcoding.myservice.client
    Hello from eu.artofcoding.myservice.impl.MyServiceImpl@2b054ac8#sayHello()
    Dez 23, 2012 3:48:45 PM eu.artofcoding.myservice.client.MyBundleActivator start
    INFO: Bundle eu.artofcoding.myservice.client started


    felix:install file:myservice-api-1.0-SNAPSHOT.jar
    felix:install file:myservice-1.0-SNAPSHOT.jar
    felix:install file:myservice-client-1.0-SNAPSHOT.jar

    g! felix:lb
    START LEVEL 1
       ID|State      |Level|Name
        0|Active     |    0|System Bundle (4.0.2)
        1|Active     |    1|Apache Felix Bundle Repository (1.6.6)
        2|Active     |    1|Apache Felix Gogo Command (0.12.0)
        3|Active     |    1|Apache Felix Gogo Runtime (0.10.0)
        4|Active     |    1|Apache Felix Gogo Shell (0.10.0)
       36|Installed  |    1|art of coding MySerice API (1.0.0.SNAPSHOT)
       37|Installed  |    1|art of coding MyService OSGi Bundle (1.0.0.SNAPSHOT)
       40|Installed  |    1|art of coding MyService OSGi Client (1.0.0.SNAPSHOT)

    update 36 file:myservice-api-1.0-SNAPSHOT.jar
    update 37 file:myservice-1.0-SNAPSHOT.jar
    update 40 file:myservice-client-1.0-SNAPSHOT.jar
