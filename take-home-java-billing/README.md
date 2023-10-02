# Billing Period REST API (PPRO TEST)

This project exposes a REST API for accessing billing period information. It provides information about billing periods based on specified rules.

## How to Access the API

The API can be accessed through HTTP calls to the following endpoints:

### List Billing Periods by Year

Endpoint: `/api/billing-periods/{year}`
Method: GET
Description: Returns all billing periods for a specific year.

Example call:

curl --location 'http://localhost:8080/v1/billing-periods/2019'

### Create Period Details by Year

Endpoint: `/api/billing-periods?year={year}`
Method: POST
Description: Returns details of a billing period based on a specific date.

Example call:

curl --location --request POST 'http://localhost:8080/v1/billing-periods?year=2019'


### Response Example

API responses will be in JSON format and follow the appropriate data structure, such as:

```json
{
  "periodId": "2019-1",
  "from": "2019-01-01",
  "to": "2019-01-04"
}

How to Use
You can use an HTTP client tool like Postman or cURL to make calls to the API endpoints. Make sure to replace http://localhost:8080 with the actual URL of the server where the API is hosted.

Running the Project Locally
Clone this repository to your local machine.
Ensure you have Java and Gradle installed.
Navigate to the project directory in the terminal.
Execute the command mvn spring-boot:run to start the application.
The application will be available at http://localhost:8080.
Be sure to adjust the URL and ports as needed based on your local setup.


Thank you!