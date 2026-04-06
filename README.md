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
| Browser Automation | Selenium WebDriver 4.41 |
| Test Runner | TestNG |
| Dependency Injection | Picocontainer |
| Reporting | ExtentReports 5 + Cucumber7 Adapter |
| Driver Management | WebDriverManager 6 |

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
│   │   ├── TestNGRunner.java         # All tests
│   │   ├── CheckoutRunner.java       # Checkout feature only
│   │   ├── SearchProductRunner.java  # SearchProduct feature only
│   │   └── FailedTestRunner.java     # Rerun failed tests
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
- **Lazy Initialization** — `PageObjectManager` creates page objects on first access, reusing the same instance for the lifetime of a scenario.
- **Failed Test Rerun** — `FailedTestRunner` re-executes only previously failed scenarios using Cucumber's `rerun` plugin.
- **Explicit Wait Strategy** — All synchronization uses `WebDriverWait` with `ExpectedConditions`; no hardcoded `Thread.sleep`.

## Features

- Explicit waits using `WebDriverWait` and `ExpectedConditions` — no hardcoded sleeps
- JavaScript click for elements susceptible to DOM re-rendering (stale element handling)
- Screenshot capture on test failure, attached inline to ExtentReports
- Rich HTML reports with ExtentReports Spark reporter
- JSON + HTML Cucumber reports for CI/CD integration
- Cross-browser support (Chrome, Edge) via Maven CLI argument
- Configurable via `global.properties` — no code changes needed to switch browsers
- Browser lifecycle managed via `@Before`/`@After` Cucumber hooks

## Test Scenarios

### `@CheckOut` — End-to-End Checkout Flow
Searches for a product, adds multiple items to the cart, proceeds to checkout, validates the product name, and verifies promo code and place order UI elements are present.

| Example | Product |
|---|---|
| Brocolli | Brocolli |
| Mango | Mango |
| Corn | Corn |

### `@SearchProduct` — Cross-Page Search Validation
Searches for a product on the landing page, navigates to the offers page, searches again, and validates the product name matches across both pages.

| Example | Product |
|---|---|
| Ban | Banana |
| Car | Carrot |
| Tom | Tomato |

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+
- Chrome or Edge browser

### Run All Tests
```bash
mvn clean test -Dbrowser=Chrome
```

### Run by Feature (Dedicated Runner)
```bash
# Run only Checkout feature
mvn test -Dtest=CheckoutRunner -Dbrowser=Chrome

# Run only SearchProduct feature
mvn test -Dtest=SearchProductRunner -Dbrowser=Chrome
```

### Run by Tag
```bash
mvn clean test -Dcucumber.filter.tags="@CheckOut" -Dbrowser=Chrome
mvn clean test -Dcucumber.filter.tags="@SearchProduct" -Dbrowser=Chrome
```

### Run Failed Tests (from last run)
```bash
mvn test -Dtest=FailedTestRunner -Dbrowser=Chrome
```

### Run from IDE
Right-click and run as TestNG on any runner class:
- `TestNGRunner.java` — all tests
- `CheckoutRunner.java` — checkout feature only
- `SearchProductRunner.java` — search feature only
- `FailedTestRunner.java` — rerun failed tests

### Reports
After a test run, reports are generated at:
- **ExtentReports HTML:** `test-output/SparkReport/`
- **Cucumber HTML:** `target/cucumber-reports/`
- **Cucumber JSON:** `target/cucumber-reports/*.json`

## License

[MIT](https://choosealicense.com/licenses/mit/)
