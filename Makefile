run:
	./gradlew bootRun

setup:
	docker-compose up -d postgres

test_curl:
	curl -H 'Content-Type: application/json' -d '\
{\
    "phoneNumber":"+37124000000",\
    "email": "test@gmail.com",\
    "monthlyIncomeAmount": 1000,\
    "amount": 10000,\
    "monthlyCreditLiabilities": 10.0,\
    "agreeToDataSharing": true,\
    "monthlyExpenses": 200,\
    "dependents": 1,\
    "maritalStatus": "DIVORCED",\
    "agreeToBeScored": true\
}' localhost:8080/application
