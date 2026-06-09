# Selenium Automation Framework

This repository is a Java-based Selenium automation framework for UI testing with a maintainable structure built around Cucumber, TestNG, and Page Object Model.

The current sample automation flow covers login validation on `https://www.saucedemo.com/`.

## Features

- Selenium WebDriver with Java
- Cucumber BDD execution flow
- TestNG runner integration
- Page Object Model structure
- Centralized driver setup
- Config-based runtime settings
- Reusable hooks for test lifecycle

## Tech Stack

- Java 17
- Maven
- Selenium `4.8.0`
- TestNG `7.8.0`
- Cucumber `7.15.0`

## Project Structure

```text
src
├─ main
│  └─ java
│     └─ org/example/Main.java
└─ test
   ├─ java
   │  ├─ driver/DriverFactory.java
   │  ├─ examples/StandaloneYoutubeDemo.java
   │  ├─ hooks/Hooks.java
   │  ├─ pages/LoginPage.java
   │  ├─ runner/Runner.java
   │  ├─ stepdefinitions/LoginStepDef.java
   │  └─ utils/ConfigReader.java
   └─ resources
      ├─ config/config.properties
      └─ features/login.feature
```

## Framework Notes

- Driver creation is centralized in `DriverFactory`
- Cucumber setup and teardown are handled in `Hooks`
- Runtime settings such as base URL and timeouts are stored in `config.properties`
- Page objects stay focused on locators and UI interactions

## Configuration

Project configuration is stored in:

- `src/test/resources/config/config.properties`

Current default values include:

- `base.url=https://www.saucedemo.com/`
- `browser.start.fullscreen=true`
- `browser.headless=false`
- `timeouts.implicit.seconds=5`
- `timeouts.explicit.seconds=10`

## How To Run

1. Clone the repository:

```bash
git clone https://github.com/aufaathallah82/SeleniumFrameworkAufa.git
```

2. Open the project in IntelliJ IDEA or another Java IDE.

3. Ensure Java 17 and Maven are installed on your machine.

4. Run the automation suite:

```bash
mvn test
```

## Current Coverage

- Login feature flow on SauceDemo
- Example standalone Selenium class for reference
- Reusable Cucumber framework structure for new UI automation work

## Author

Muhammad Aufa Athallah
