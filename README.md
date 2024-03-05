Please go thorugh the readme for sample request and response for each user request.
1) Add train
Url: http://localhost:8085/train/add
Request:
{
    "trainNumber": 23454,
    "trainName": "VandeBharat",
    "stations": ["Varanasi", "Delhi"]
}
Response:
http_code:200 ok
{
    "trainNumber": 23454,
    "trainName": "VandeBharat",
    "stations": [
        "Varanasi",
        "Delhi"
    ]
}

2) Remove or delete train
Url: http://localhost:8085/train/remove
Request:
{
    "trainNo": 12345
}
Response:
OK
3) Update train details
Url: http://localhost:8085/train/update
Request:
{
    "trainNumber": 12582,
    "trainName": "VandeBharat",
    "stations": ["Varanasi", "Delhi"]
}
Response:
{
    "trainNumber": 12582,
    "trainName": "VandeBharat",
    "stations": [
        "Varanasi",
        "Delhi"
    ]
}

5) Find train betwenn source and destination
Url:http://localhost:8085/train/find
Request:
{
    "source": "Varanasi",
    "destination": "Lucknow"
}
Response: 
[
    {
        "trainNumber": 12345,
        "trainName": "BSBSSUPERFAST",
        "stations": [
            "Delhi",
            "Himachal"
        ]
    }
]
