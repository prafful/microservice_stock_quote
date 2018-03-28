# microservice_stock_quote

GET End Point:
http://localhost:8181/stocks/get/quotes/prafful

JSON Response:
[
    "INFY.BO",
    "LTTS.BO",
    "HINDUNILVR.BO",
    "BEL.NS",
    "BPCL.NS"
]

__________________________________________________________________________________________________________________________________

POST End Point: 
http://localhost:8181/stocks/add

JSON Request Body:
{
    "username":"prafful",
    "quotes":["INFY.BO","LTTS.BO","HINDUNILVR.BO", "BEL.NS", "BPCL.NS"]
}

JSON Response:
[
    {
        "id": 4,
        "username": "prafful",
        "quote": "INFY.BO"
    },
    {
        "id": 5,
        "username": "prafful",
        "quote": "LTTS.BO"
    },
    {
        "id": 6,
        "username": "prafful",
        "quote": "HINDUNILVR.BO"
    },
    {
        "id": 7,
        "username": "prafful",
        "quote": "BEL.NS"
    },
    {
        "id": 8,
        "username": "prafful",
        "quote": "BPCL.NS"
    }
]

