package com.isep.acme.mongoTests;

import com.isep.acme.model.model_MongoDB.ProductMongo;
import com.isep.acme.model.model_MongoDB.ReviewMongo;
import com.isep.acme.model.model_MongoDB.UserMongo;
import com.isep.acme.repositories.repositories_MongoDB.ReviewRepositoryMongo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import java.util.Arrays;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@ActiveProfiles("test") // Activate the test profile
public class MongoCrudTestsReview {

    @Autowired
    private ReviewRepositoryMongo reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    private ReviewMongo review;
    private UserMongo user;
    private ProductMongo product;

    @BeforeEach
    void setUp() {
        mongoTemplate.dropCollection(ReviewMongo.class);
        mongoTemplate.dropCollection(UserMongo.class);
        mongoTemplate.dropCollection(ProductMongo.class);

        user = new UserMongo("André", "password", "André Ferreira", "111111111", "Rua ABC");
        user.setId("10");
        mongoTemplate.insert(user);

        product = new ProductMongo("q73f947gn681", "A new product", "brand new");
        mongoTemplate.insert(product);

        review = new ReviewMongo();
        review.setUser(user);
        review.setProduct(product);
        review.setApprovalStatus("pending");
    }

    @Test
    void testCreateReview() {
        ReviewMongo savedReview = reviewRepository.save(review);
        assertNotNull(savedReview.getId());
    }

    @Test
    void testReadReview() {
        ReviewMongo savedReview = reviewRepository.save(review);
        Optional<ReviewMongo> foundReview = reviewRepository.findById(savedReview.getId());
        assertTrue(foundReview.isPresent());
        assertEquals(savedReview.getId(), foundReview.get().getId());
    }

    @Test
    void testUpdateReview() {
        ReviewMongo savedReview = reviewRepository.save(review);
        savedReview.setApprovalStatus("approved");
        ReviewMongo updatedReview = reviewRepository.save(savedReview);
        assertEquals("approved", updatedReview.getApprovalStatus());
    }

    @Test
    void testDeleteReview() {
        ReviewMongo savedReview = reviewRepository.save(review);
        reviewRepository.deleteById(savedReview.getId());
        Optional<ReviewMongo> deletedReview = reviewRepository.findById(savedReview.getId());
        assertFalse(deletedReview.isPresent());
    }

    @Test
    void testFindByProduct() {
        reviewRepository.save(review);
        Optional<List<ReviewMongo>> reviewsByProduct = reviewRepository.findByProduct(product);
        assertTrue(reviewsByProduct.isPresent());
        assertFalse(reviewsByProduct.get().isEmpty());
        assertEquals(product.getProductID(), reviewsByProduct.get().get(0).getProduct());
    }

    @Test
    void testFindByApprovalStatus() {
        reviewRepository.save(review);
        Optional<List<ReviewMongo>> reviewsByStatus = reviewRepository.findByApprovalStatus("pending");
        assertTrue(reviewsByStatus.isPresent());
        assertFalse(reviewsByStatus.get().isEmpty());
        assertEquals("pending", reviewsByStatus.get().get(0).getApprovalStatus());
    }

    @Test
    void testFindByProductAndApprovalStatus() {
        reviewRepository.save(review);
        Optional<List<ReviewMongo>> reviewsByProductAndStatus = reviewRepository.findByProductAndApprovalStatus(product, "pending");
        assertTrue(reviewsByProductAndStatus.isPresent());
        assertFalse(reviewsByProductAndStatus.get().isEmpty());
        assertEquals("pending", reviewsByProductAndStatus.get().get(0).getApprovalStatus());
        assertEquals(product.getProductID(), reviewsByProductAndStatus.get().get(0).getProduct());
    }

    @Test
    void testFindByUser() {
        reviewRepository.save(review);
        Optional<List<ReviewMongo>> reviewsByUser = reviewRepository.findByUser(user);
        assertTrue(reviewsByUser.isPresent());
        assertFalse(reviewsByUser.get().isEmpty());
        assertEquals(user.getId(), reviewsByUser.get().get(0).getUser());
    }

    @Test
    void testGetRecommendedReviews() {
        ReviewMongo savedReview = reviewRepository.save(review);
        List<ReviewMongo> reviews = Arrays.asList(savedReview);
        Optional<List<ReviewMongo>> recommendedReviews = reviewRepository.getRecommendedReviews(reviews);
        assertTrue(recommendedReviews.isPresent());
        assertFalse(recommendedReviews.get().isEmpty());
        assertEquals(savedReview.getId(), recommendedReviews.get().get(0).getId());
    }
}
