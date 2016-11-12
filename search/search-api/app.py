from neo4jrestclient.client import GraphDatabase
from neo4jrestclient import client


#select data from neo4j to be filterd by semantic engine to give personalized data
def select(db):
    q="start n=node(*) match (n) where n.id =~ '.*e.*' return (n)"
    results = db.query(q, returns=(client.Node, str, client.Node))
    st = ""
    for r in results:
        st = st + r[0]["title"]
    return st

def main():
    db = GraphDatabase("http://localhost:7474", username="neo4j", password="experio@123")
    return db

def fetch_data():
    db = main()
    return select(db)