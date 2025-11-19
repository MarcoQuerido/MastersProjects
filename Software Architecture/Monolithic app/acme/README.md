# Logical Views

## Level 2 View
![L2_view](./Docs/L2_view.png)

## Level 3 View
![L3_view](./Docs/Level3Diagram.jpeg)
# Use Cases

![UseCaseDiagram1.jpg](./Docs/UseCaseDiagram1.jpeg)

## Use Case 1 Description:
- There will be a list of all the reviews, sorted by the quantity of upvotes so that the minimum number of upvotes should be 4, and at least 65% of the votes should be upvote. The list is sorted by the quantity of upvotes.

|     REQ.001     | View Reviews                                              |
|:---------------:|-----------------------------------------------------------|
| Objective       | View all the reviews                                      |
| Description     | The user can view a list of reviews.                      |
| Pre-Conditions  | None                                                      |
| Post-Conditions | The user can see the filtered and sorted list of reviews. |

| Main Flow |                                                                                            |
|:---------:|------------------------------------------------------------------------------------------------------------|
| Steps     | Description                                                                                                |
| 1         | The user requests to view reviews.                                                                         |
| 2         | The system retrieves reviews from the database.                                                            |
| 3         | The system sorts the reviews by the quantity of upvotes.                                                   |
| 4         | The system filters the reviews to include only those with a minimum of 4 upvotes and at least 65% upvotes. |
| 5         | The system displays the filtered and sorted list of reviews to the user.                                   |


## Use Case 2 Description:
- All reviews offered by other users that vote at least 50% of the times like the requested user. All the reviews offered by a 
  user that votes like me at least 50% of the times. The algorithm will recommend the reviews offered by a user who the user 
  votes 50%. The algorithm will recommend the reviews offered by a user who the users vote 50% like me. Recommend all the 
  reviewers of that users except the ones I already voted. 


![UseCase2.png](./Docs/UseCaseDiagram2.png)

|     REQ.002     | Retrieve Reviews                                   |
|:---------------:|----------------------------------------------------|
| Objective       | Retrieve all the reviews                           |
| Description     | The database provides reviews to the system.       |
| Pre-Conditions  | None                                               |
| Post-Conditions | The system receives the reviews from the database. |

|    Main Flow    |                                          |
|:---------------:|-------------------------------------------------------|
| Steps           | Description                                           |
| 1               | The database provides reviews to the system.          |
| 2               | The database retrieves the reviews from the database. |


# Changes to the main application

## Added a model_MongoDB folder with the following structure:

```bash
.  
└── model/  
    └── model_MongoDB/  
        ├── AggregatedRatingMongo
        ├── ProdImageMongo 
        ├── ProductMongo 
        ├── RatingMongo  
        ├── ReviewMongo  
        └── UserMongo 
```

- Each Mongo model class is an adaptation of the initial project's main models, in order to adapt to a MongoDB database (@Document, @Id and @Field annotations necessary for MongoDB data creation)

## Added a neo4j folder with the following structure:

```bash
.  
└── model/  
    └── neo4j/  
        ├── AggregatedRatingNeo4J
        ├── ProdImageNeo4J
        ├── ProductNeo4J 
        ├── RatingNeo4J  
        ├── ReviewNeo4J  
        └── UserNeo4J 
```

- Each Neo4J model class is an adaptation of the initial project's main models, in order to adapt to a Neo4j database(@Document, @Id and @Property annotations necessary for Neo4J data creation)


## Added a repositories_MongoDB folder with the following structure:

```bash
.  
└── repositories/  
    └── repositories_MongoDB/  
        ├── AggregatedRatingRepositoryMongo
        ├── ImageRepositoryMongo 
        ├── ProductRepositoryMongo 
        ├── RatingRepositoryMongo  
        ├── ReviewRepositoryMongo  
        └── UserRepositoryMongo 
```

- Each Mongo repository interface is an adaptation of the initial project's main repository interfaces, in order to adapt to a MongoDB database (@Document annotation necessary for MongoDB data saving and according Mongo methods from repositories_MongoDB/impl classes)

## Added a neo4j folder with the following structure:

```bash
.  
└── repositories/  
    └── neo4j/  
        ├── AggregatedRatingRepositoryNeo4j
        ├── ImageRepositoryNeo4j 
        ├── ProductRepositoryNeo4j 
        ├── RatingRepositoryNeo4j  
        ├── ReviewRepositoryNeo4j  
        └── UserRepositoryNeo4j 
```

- Each Neo4J repository interface is an adaptation of the initial project's main repository interfaces, in order to adapt to a Neo4J database 

## Added a impl folder with the following structure:

```bash
.  
└── repositories/  
    └── repositories_MongoDB/
	└── impl/
	    ├── AggregatedRatingRepositoryMongoImpl
            ├── ImageRepositoryMongoImpl
            ├── ProductRepositoryMongoImpl
            ├── RatingRepositoryMongoImpl  
            ├── ReviewRepositoryMongoImpl  
            └── UserRepositoryMongoImpl
```

- Each Mongo impl class is an implementation of it's corresponding repository interface, activated by profiles, in order to use the repository methods(@Repository and @Profile annotations are necessary)


## Added a impl folder with the following structure:

```bash
.  
└── repositories/  
    └── neo4j/
	└─── impl/
	    ├── AggregatedRatingRepositoryNeo4JImpl
            ├── ImageRepositoryNeo4JImpl
            ├── ProductRepositoryNeo4JImpl
            ├── RatingRepositoryNeo4JImpl  
            ├── ReviewRepositoryNeo4JImpl  
            └── UserRepositoryNeo4JImpl
```

- Each Neo4J impl class is an implementation of it's corresponding repository interface, activated by profiles, in order to use the repository methods(@Repository and @Profile annotations are necessary)


## Added a SkuGenerator1 class in com.isep.acme folder.

- This class returns a 12 character long, randomized code from a String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

- The class is later invoked in the testCreateProductWithSkuGenerator class


## Added configuration files in the following folder:

```bash
.  
└── src/  
    └── main/
	    └── resources/
            ├── application-mongodb.properties
            ├── application-test.properties
            ├── docker-compose.yaml
            └── Dockerfile   
```

- application-mongodb.properties ensures that all the necessary parameters to connect to the mongodb database are set;

- application-test.properties ensures that the uri for database authentication is set;

- docker-compose.yaml is the configuration file to start the mongodb database in a docker container, including a mongo-express server for better graphical visualization of the database collections;

- Dockerfile ensures that the latest image of mongo is used.


## Added test classes in the following folder:

```bash
.  
└── test/  
    └── java/
	    └── com.isep.acme/
            └── mongoTests/
                ├── MongoConnectivityTests
                ├── MongoCrudTestsProduct
                ├── MongoCrudTestsRating
                ├── MongoCrudTestsReview   
                ├── MongoCrudTestsUser
                └── TestMongoDBConfig
```

- MongoConnectivityTests has the following tests:
    - testDatabaseConnection
    - testApiEndpoint

- MongoCrudTestsProduct has the following tests:
    - testFindProductById
    - testSaveProduct
    - testUpdateProductBySku
    - testDeleteProductBySku
    - testCreateProductWithSkuGenerator

- MongoCrudTestsRating has the following tests:
    - testSaveRating
    - testFindById
    - testFindByRate
    - testUpdateRating
    - testDeleteRating
    - testDeleteRatingById
    - testDeleteAllRatings

- MongoCrudTestsReview has the following tests:
    - testCreateReview
    - testReadReview
    - testUpdateReview
    - testDeleteReview
    - testFindByProduct
    - testFindByApprovalStatus
    - testFindByProductAndApprovalStatus
    - testFindByUser
    - testGetRecommendedReviews

- MongoCrudTestsUser has the following tests:
    - testCreateUser
    - testReadUser
    - testUpdateUser
    - testDeleteUser
    - testFindAllUsers
    - testFindByUsername