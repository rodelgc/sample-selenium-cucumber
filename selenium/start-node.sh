#!/usr/bin/env bash
java -jar selenium-server-standalone-$SELENIUM_SERVER_VERSION.jar \
        -port $NODE_PORT \
        -role node \
        -nodeConfig nodeConfig.json \
        -servlet org.openqa.grid.web.servlet.LifecycleServlet