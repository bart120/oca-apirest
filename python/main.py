from fastapi import FastAPI, Response, HTTPException
from models.offer import Offer
from fastapi.middleware.cors import CORSMiddleware

app = FastAPI()

origins = [
    "http://localhost:8000",
    "http://localhost"
]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins
)

@app.get("/offers")
def get_offers():
    return [
        Offer(1, "Illimité mobile"),
        Offer(2, "Illimité voix")
    ]

@app.get("/offers/{id}")
def get_offer_by_id(id:int):
    items=[
        Offer(1, "Illimité mobile"),
        Offer(2, "Illimité voix")
    ]
    for x in items:
        if x.id == id:
            return x
    #raise HTTPException(status_code=404, detail="Offer not found")
    return Response(status_code=404, content={"detail":"Offer not found"})
    