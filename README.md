Application split provided amount for different investments depending on chosen style.
Available styles: bezpieczny, zrównoważony, agresywny
Available investments: Polskie, Zagraniczne, Pieniężne 

Example:

../investments/invest
POST
{
  "amount": 10000,
  "style": "bezpieczny",
  "funds": [
    {
      "type": "Polskie",
      "name": "Polski1"
    },
    {
      "type": "Polskie",
      "name": "Polski2"
    },
    {
      "type": "Polskie",
      "name": "Polski3"
    },
    {
      "type": "Zagraniczne",
      "name": "Zagraniczny1"
    },
    {
      "type": "Zagraniczne",
      "name": "Zagraniczny2"
    },
    {
      "type": "Pieniężne",
      "name": "Pieniężny1"
    }
  ]
}

result - status 200

{
    "refund": 0,
    "investments": [
        {
            "id": 1,
            "type": "Polskie",
            "name": "Polski1",
            "amount": 668,
            "percentage": 6.68
        },
        {
            "id": 2,
            "type": "Polskie",
            "name": "Polski2",
            "amount": 666,
            "percentage": 6.66
        },
        {
            "id": 3,
            "type": "Polskie",
            "name": "Polski3",
            "amount": 666,
            "percentage": 6.66
        },
        {
            "id": 4,
            "type": "Zagraniczne",
            "name": "Zagraniczny1",
            "amount": 3750,
            "percentage": 37.5
        },
        {
            "id": 5,
            "type": "Zagraniczne",
            "name": "Zagraniczny2",
            "amount": 3750,
            "percentage": 37.5
        },
        {
            "id": 6,
            "type": "Pieniężne",
            "name": "Pieniężny1",
            "amount": 500,
            "percentage": 5
        }
    ]
}