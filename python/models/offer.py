from database import Base
from sqlalchemy import String,Boolean,Integer,Column,Text
from pydantic import BaseModel

class Offer(Base):
    __tablename__="offers"
    id=Column(Integer,primary_key=True)
    name=Column(String(80),nullable=False,unique=True,name="label")
    
class OfferSerializer(BaseModel):
    id:int
    name:str
    class Config:
        from_attributes=True

    
        
