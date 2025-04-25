Football World Cup Score Board

Exercise asks to design and build a realtime score board for matches in progress. Once the match is over the score will be removed from the board. Implementation will be focused on the football matches, however the desing will allow to expand API to build suport for different types of matches is needed.

For the purpose of this solution I am making following assumptions:
* data for the score board will be stored in in-memory data structure - HashMap
* there cannot be a two team with the same name in other words all team names will be unique across population - key for any given match will be concatenation of team name
* solution focuses on keeping the score updates without any additional team related information (who scored, own goals etc), hence the teams will be represented by a simple String. this can be further expanded if needed adding more robust team implementation
* for the purpose of testing i will build a simple EventFeed class that will random update given match scores. I assume the single match will be handled by a single thread, to avoid issues with concurrency access to the in-memory datastore
