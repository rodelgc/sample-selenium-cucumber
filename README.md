# README

This is a Gradle project that contains Selenium WebDriver tests that can be run on Chrome or Firefox using Cucumber framework.
To specify the browser you wish to run the tests on, open the [config.json](https://github.com/rodel-calasagsag/code-challenge-ui-automation-testing/blob/master/src/test/resources/com/rodelcalasagsag/config.json) file and set the `browserName` field to either `"chrome"` (default) of `"firefox"`.

This project contains 3 tests that cover the following challenge steps:
1. Select item from pulldown menu 
2. Input text into a textbox
3. Click button
4. Click page link
5. Select value from a table

This test uses 2 Docker images:
- Zalenium - contains a Selenium Grid that the tests will use
- OpenJDK - for the JDK

## Requirements
1. This test can be run in any Windows/Mac/Linux host
2. Host machine should have the following installed:
    - Git
    - Docker for Windows/Mac/Linux (not Docker Toolbox)

## Instructions
1. Clone this repository by opening a terminal and executing:
    ```
    $ git clone https://github.com/rodel-calasagsag/code-challenge-ui-automation-testing.git
    ```
1. Navigate to the project directory:
    ```
    $ cd code-challenge-ui-automation-testing
    ```
1. Pull docker-selenium image
    ```
    $ docker pull elgalu/selenium
    ```
1. Pull Zalenium docker image
    ```
    $ docker pull dosel/zalenium
    ```
1. Build the docker image for this test
    ```
    $ docker build -t my-tests .
    ```
1. Launch `docker-run-zalenium.bat` if you're on Windows, or `docker-run-zalenium.sh` if you're on a Unix computer either by double-clicking it, or running it from a separate terminal. This will start a new Zalenium container which contains the Selenium Grid that the test will be using.
1. Run the tests by using the Gradle wrapper inside the project
    ```
    $ docker run --rm --name my-tests-container --network="host" my-tests ./gradlew clean test --info
    ```
1. Open up any browser, and go to http://localhost:4444/grid/admin/live?refresh=20 to see a live preview of the running tests inside the Zalenium container
1. You can also access the Selenium Grid Console when you go to http://localhost:4444/grid/console
1. To view the recordings and logs of the tests, go to http://localhost:4444/dashboard/
1. When the tests are done, the OpenJDK container (named `my-tests-container`) will automatically stop. To stop the Zalenium container, you need to run
    ```
    $ docker stop zalenium
    ```