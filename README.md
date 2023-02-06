gradle clean test   
allure serve build/allure-results

apply the below code in given() in request
.filter(new AllureRestAssured())