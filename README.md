# Cucumber-Master-Class

A production-grade BDD (Behavior-Driven Development) end-to-end UI automation framework for testing web applications, built with Cucumber 7, Selenium WebDriver, and TestNG.

## Overview

This project demonstrates industry-standard test automation practices using the **Page Object Model (POM)** design pattern, **Dependency Injection**, and **Gherkin** syntax for human-readable acceptance criteria. It automates browser-based acceptance tests against the GreenKart demo e-commerce site.

## Tech Stack

| Component | Technology |
|---|---|
| Language | Java 17 |
| Build Tool | Apache Maven |
| BDD Framework | Cucumber 7 (Gherkin) |
| Browser Automation | Selenium WebDriver 4.20 |
| Test Runner | TestNG |
| Dependency Injection | Picocontainer |
| Reporting | ExtentReports 5 + Cucumber7 Adapter |
| Driver Management | WebDriverManager |

## Architecture

The framework follows a clean layered architecture:

```
src/test/
├── java/
│   ├── pages/           # Page Object Model — one class per page
│   │   ├── LandingPage.java
│   │   ├── OfferPage.java
│   │   ├── CheckOutPage.java
│   │   └── PageObjectManager.java
│   ├── runner/          # TestNG + Cucumber runners
│   │   ├── TestNGRunner.java
│   │   └── FailedTestRunner.java
│   ├── stepDefinition/  # Gherkin step implementations
│   │   ├── LandingPageStepDef.java
│   │   ├── OfferPageStepDef.java
│   │   ├── CheckOutStepDef.java
│   │   └── Hook.java
│   └── utils/           # Shared infrastructure
│       ├── TestBase.java
│       ├── BaseUtil.java
│       └── GenericUtil.java
└── resources/
    ├── features/        # Gherkin feature files (.feature)
    ├── global.properties
    └── extent.properties
```

### Design Patterns Used

- **Page Object Model (POM)** — Encapsulates page locators and actions in dedicated classes, reducing duplication and improving maintainability.
- **Dependency Injection (Picocontainer)** — Shares state (`BaseUtil`) across step definitions per scenario without tight coupling.
- **Singleton WebDriver** — One browser session per scenario, managed by `TestBase`.
- **Failed Test Rerun** — `FailedTestRunner` re-executes only previously failed scenarios using Cucumber's `rerun` plugin.

## Features

- Explicit waits using `WebDriverWait` and `ExpectedConditions` — no hardcoded sleeps
- JavaScript click for elements susceptible to DOM re-rendering (stale element handling)
- Screenshot capture on test failure, attached inline to ExtentReports
- Rich HTML reports with ExtentReports Spark reporter
- JSON + HTML Cucumber reports for CI/CD integration
- Cross-browser support (Chrome, Edge) via Maven CLI argument
- Configurable via `global.properties` — no code changes needed to switch browsers

## Test Scenarios

### `@CheckOut` — End-to-End Checkout Flow
Searches for a product, adds multiple items to the cart, proceeds to checkout, validates the product name, and verifies promo code and place order UI elements are present.

### `@SearchProduct` — Cross-Page Search Validation *(demo site limitation)*
Searches for a product on the landing page, navigates to the offers page (new browser window), searches again, and validates the product name matches across both pages.

> **Note:** The GreenKart demo site (`rahulshettyacademy.com`) no longer supports partial product search reliably. The `@SearchProduct` scenarios may fail due to changes in the demo site's data. The `@CheckOut` feature is fully functional.

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+
- Chrome or Edge browser

### Run All Tests
```bash
mvn clean test -Dbrowser=Chrome
```

### Run Specific Tag
```bash
mvn clean test -Dcucumber.filter.tags="@CheckOut" -Dbrowser=Chrome
```

### Run from IDE
Execute `TestNGRunner.java` directly as a TestNG test.

### Reports
After a test run, reports are generated at:
- **ExtentReports HTML:** `test-output/SparkReport/`
- **Cucumber HTML:** `target/cucumber-reports/cucumber-rep.html`
- **Cucumber JSON:** `target/cucumber-reports/cucumber-rep.json`

## License

[MIT](https://choosealicense.com/licenses/mit/)
