# Developers

## Building AS Tools



### Setting up Maven

All AS Tools projects are built in Java using [Apache Maven](http://maven.apache.org/).

After you have installed Maven run the following command to add the ActiveSpaces Java library to the Maven repository:

```
mvn install:install-file -Dfile=$AS_HOME/lib/as-common.jar -DgroupId=com.tibco.as -DartifactId=as-common -Dversion=2.1.2 -Dpackaging=jar
```


### Getting the Source

```
git clone https://github.com/TIBCOSoftware/as-tools.git
```


### Building the Projects

Clone the Xeger project from [https://github.com/bluezio/xeger](https://github.com/bluezio/xeger) and build it with the following command:

```
mvn clean install
```

Open a terminal and cd to the `as-tools` checkout location.

Build all modules using the following command:

```
mvn clean install
```

You should see the following message indicating that the projects built successfully:

```
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 41.801s
[INFO] Finished at: Tue Apr 29 17:56:45 PDT 2014
[INFO] Final Memory: 29M/81M
[INFO] ------------------------------------------------------------------------
```