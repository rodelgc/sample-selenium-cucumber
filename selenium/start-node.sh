#!/usr/bin/env bash
java -jar selenium-server-standalone-3.141.59.jar -port 4555 -role node -nodeConfig nodeConfig.json -servlet org.openqa.grid.web.servlet.LifecycleServlet