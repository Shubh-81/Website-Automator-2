# Website Automation using Selenium and ChromeDriver

This Java code is an example of automating certain actions on a website using Selenium WebDriver and ChromeDriver. The code performs actions such as logging in, navigating to specific pages, uploading documents, and downloading files on a web application.

## Prerequisites

Before running this code, make sure you have the following installed:

1. Java Development Kit (JDK): The code is written in Java, so you'll need the JDK installed on your machine.
2. Chrome browser: The code uses ChromeDriver to automate actions on the Chrome browser. Make sure you have Chrome installed.

## Libraries Used

The code utilizes the following libraries:

- **Selenium WebDriver**: A powerful tool for automating browsers, including Chrome, Firefox, etc.
- **ChromeDriver**: WebDriver for Chrome, allowing automation of Chrome browser.
- **WebDriverManager**: A library used to manage WebDriver binaries for various browsers.

## Setting Up

1. Clone or download the repository to your local machine.

2. Import the project into your preferred Java IDE (e.g., Eclipse, IntelliJ).

3. Ensure that you have the necessary Selenium dependencies and WebDriverManager configured in your project.

## Usage

1. Modify the `main` method in the `test` class to suit your specific requirements:

   - Update the URL in `driver.get()` to the website you want to automate.
   - Adjust any other locators, elements, or input fields according to the website's structure.

2. Run the `main` method to execute the automation script.

3. The script will open the Chrome browser and navigate to the specified URL.

4. The code includes three main functions to perform specific actions:

   - `login`: This function performs the login process using the provided username, password, and OTP.
   - `upload`: This function automates the document upload process.
   - `download`: This function automates the file download process.

   Uncomment the function calls in the `main` method to perform the actions you need.

5. Review the code and adapt it according to the specific website and actions you want to automate.
