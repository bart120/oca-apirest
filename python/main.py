from fastapi import FastAPI, Response, HTTPException, status
from models.offer import Offer, OfferSerializer
from fastapi.middleware.cors import CORSMiddleware
from fastapi.responses import RedirectResponse
from typing import List
from database import SessionLocal

app = FastAPI()
db=SessionLocal()
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
   offers=db.query(Offer).all()
   return offers

@app.get("/offers/{id}")
def get_offer_by_id(id:int):
    items = db.query(Offer).all()
    for x in items:
        if x.id == id:
            return x
    #raise HTTPException(status_code=404, detail="Offer not found")
    return Response(status_code=404, content="detail:Offer not found")

@app.get('/offers/{id}')
def get_offer_by_id(id:int):
    offer=db.query(Offer).filter(Offer.id==id).first()
    return offer

@app.post('/offers', response_model=OfferSerializer, status_code=201)
def add_offer(offer:OfferSerializer):
    of = Offer(name=offer.name)
    db.add(of)
    db.commit()
    #db.rollback()
    return of