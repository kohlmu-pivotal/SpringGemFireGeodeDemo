# SpringGemFireGeodeDemo

A simple demo to show how Spring Data For VMware GemFire can interact with Apache Geode 1.15.1. This Demo is very simple where a Geode 1.15.1 Locator and Server will be started. A Replicate region, `Customer` will be created on server. The Client, Spring Data For VMware Gemfire, will then connect to the Geode server and create customers.

## Setup

* Ensure that a user account has been registered with [https://commercial-repo.pivotal.io/](https://commercial-repo.pivotal.io/)
* Edit local `~/.gradle/gradle.properties` file and add `gemfireRepoUserName` and `gemfireRepoPassword` to match the username and password registered in the step above

## Running Demo

To launch a server:
Open terminal window and run ``` ./gradlew server:bootRun```

To launch a client:
Open terminal window and ```./gradlew client:bootRun```

After starting both client and server, open a web browser and navigate to `localhost:8080/customers`. This should now display `No Values found`.

Then navigate back to `localhost:8080/customers/add` which will trigger the client to add customer to the server.

If `localhost:8080/customers` is then run again, Customer names should appear.

The client is configured to use Proxy regions, so no data is stored locally.

To clear the server region run `localhost:8080/customer/clear` and all entries will be removed from the region.

Equivalent curl commands can be used to replicate the above Web browser steps

```curl http://localhost:8080/customers```

```curl http://localhost:8080/customers/add```

```curl http://localhost:8080/customers/clear```
