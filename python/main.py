from fastapi import FastAPI, Response, HTTPException, status
from models.offer import Offer
from fastapi.middleware.cors import CORSMiddleware
from fastapi.responses import RedirectResponse
from typing import List

app = FastAPI()

origins = [
    "http://localhost:8000",
    "http://localhost"
]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins
)

@app.exception_handler(404)
def custom_error(request, __):
    #if request.path.startswith("/api"):
    #    return RedirectResponse("/")
    return Response(status_code=404, content="detail:Boulet!!!")


@app.get("/offers")
def get_offers():
   return all_offers

@app.get("/offers/{id}")
def get_offer_by_id(id:int):
    items = all_offers
    for x in items:
        if x.id == id:
            return x
    #raise HTTPException(status_code=404, detail="Offer not found")
    return Response(status_code=404, content="detail:Offer not found")

@app.post("/offers", response_model=Offer, status_code=status.HTTP_201_CREATED)
async def add_offer(offer:Offer):
    if offer.name == "":
        return Response(status_code=status.HTTP_400_BAD_REQUEST, content="Name required")
    all_offers.append(offer)
    return offer
    #return Response(status_code=201, content=offer)
    
all_offers = [
        Offer(id=1,name= "Illimité mobile"),
        Offer(id=2,name= "Illimité voix")
    ]