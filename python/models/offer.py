from database import Base
from sqlalchemy import String,Boolean,Integer,Column,Text

class Offer(Base):
    __tablename__="offers"
    id=Column(Integer,primary_key=True)
    name=Column(String(80),nullable=False,unique=True)
    
        
