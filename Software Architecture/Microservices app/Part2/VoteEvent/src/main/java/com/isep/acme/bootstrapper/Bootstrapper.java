package com.isep.acme.bootstrapper;

import com.isep.acme.model.Product;
import com.isep.acme.model.Review;
import com.isep.acme.model.Role;
import com.isep.acme.model.User;
import com.isep.acme.model.Vote;
import com.isep.acme.repositories.ProductRepository;
import com.isep.acme.repositories.ReviewRepository;
import com.isep.acme.repositories.UserRepository;
import com.isep.acme.repositories.VoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Bootstrapper implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Bootstrapper.class);

    @Autowired
    private ReviewRepository rRepo;

    @Autowired
    private ProductRepository pRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private VoteRepository voteRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        bootstrapUsers();
        bootstrapProducts();
        bootstrapReviews();
        bootstrapVotes();
    }

    private void bootstrapUsers() {

        //admin
        if (userRepo.findByUsername("admin1@mail.com").isEmpty()) {
            User admin1 = new User("admin1@mail.com", encoder.encode("AdminPW1"),
                    "Jose Antonio", "355489123", "Rua Um");
            admin1.addAuthority(new Role(Role.Admin));

            logger.info(String.format("Adding %s", admin1));
            userRepo.save(admin1);
        }

        if (userRepo.findByUsername("admin2@mail.com").isEmpty()) {
            User mod1 = new User("admin2@mail.com", encoder.encode("AdminPW2"),
                    "Antonio Jose", "321984553", "Rua dois");
            mod1.addAuthority(new Role(Role.Mod));
            logger.info(String.format("Adding %s", mod1));
            userRepo.save(mod1);
        }
        if (userRepo.findByUsername("user1@mail.com").isEmpty()) {
            User user1 = new User("user1@mail.com", encoder.encode("userPW1"),
                    "Nuno Miguel", "253647883", "Rua tres");
            user1.addAuthority(new Role(Role.RegisteredUser));
            logger.info(String.format("Adding %s", user1));
            userRepo.save(user1);
        }
        if (userRepo.findByUsername("user2@mail.com").isEmpty()) {
            User user2 = new User("user2@mail.com", encoder.encode("userPW2"),
                    "Miguel Nuno", "253698854", "Rua quatro");
            user2.addAuthority(new Role(Role.RegisteredUser));
            logger.info(String.format("Adding %s", user2));
            userRepo.save(user2);
        }
        if (userRepo.findByUsername("user3@mail.com").isEmpty()) {
            User user3 = new User("user3@mail.com", encoder.encode("userPW3"),
                    "Antonio Pedro", "254148863", "Rua vinte");
            user3.addAuthority(new Role(Role.RegisteredUser));
            logger.info(String.format("Adding %s", user3));
            userRepo.save(user3);
        }

        if (userRepo.findByUsername("user4@mail.com").isEmpty()) {
            User user4 = new User("user4@mail.com", encoder.encode("userPW4"),
                    "Pedro Antonio", "452369871", "Rua cinco");
            user4.addAuthority(new Role(Role.RegisteredUser));
            logger.info(String.format("Adding %s", user4));
            userRepo.save(user4);
        }
        if (userRepo.findByUsername("user5@mail.com").isEmpty()) {
            User user5 = new User("user5@mail.com", encoder.encode("userPW5"),
                    "Ricardo Joao", "452858596", "Rua seis");
            user5.addAuthority(new Role(Role.RegisteredUser));
            logger.info(String.format("Adding %s", user5));
            userRepo.save(user5);
        }
        if (userRepo.findByUsername("user6@mail.com").isEmpty()) {
            User user6 = new User("user6@mail.com", encoder.encode("userPW6"),
                    "Joao Ricardo", "425364781", "Rua sete");
            user6.addAuthority(new Role(Role.RegisteredUser));
            logger.info(String.format("Adding %s", user6));
            userRepo.save(user6);
        }
        if (userRepo.findByUsername("user7@mail.com").isEmpty()) {
            User user7 = new User("user7@mail.com", encoder.encode("userPW7"),
                    "Luis Pedro", "526397747", "Rua oito");
            user7.addAuthority(new Role(Role.RegisteredUser));
            logger.info(String.format("Adding %s", user7));
            userRepo.save(user7);
        }
        if (userRepo.findByUsername("user8@mail.com").isEmpty()) {
            User user8 = new User("user8@mail.com", encoder.encode("userPW8"),
                    "Pedro Luis", "523689471", "Rua nove ");
            user8.addAuthority(new Role(Role.RegisteredUser));
            logger.info(String.format("Adding %s", user8));
            userRepo.save(user8);
        }
        if (userRepo.findByUsername("user9@mail.com").isEmpty()) {
            User user9 = new User("user9@mail.com", encoder.encode("userPW9"),
                    "Marco Antonio", "253148965", "Rua dez");
            user9.addAuthority(new Role(Role.RegisteredUser));
            logger.info(String.format("Adding %s", user9));
            userRepo.save(user9);
        }
        if (userRepo.findByUsername("user10@mail.com").isEmpty()) {
            User user10 = new User("user10@mail.com", encoder.encode("userPW10"),
                    "Antonio Marco", "201023056", "Rua onze");
            user10.addAuthority(new Role(Role.RegisteredUser));
            logger.info(String.format("Adding %s", user10));
            userRepo.save(user10);
        }
        if (userRepo.findByUsername("user11@mail.com").isEmpty()) {
            User user11 = new User("user11@mail.com", encoder.encode("userPW11"),
                    "Rui Ricardo", "748526326", "Rua doze");
            user11.addAuthority(new Role(Role.RegisteredUser));
            logger.info(String.format("Adding %s", user11));
            userRepo.save(user11);
        }
    }

    private void bootstrapProducts() {
        if (pRepo.findBySku("asd578fgh267").isEmpty()) {
            Product p1 = new Product(1L, "asd578fgh267");
            logger.info(String.format("Adding %s", p1));
            pRepo.save(p1);
        }
        if (pRepo.findBySku("c1d4e7r8d5f2").isEmpty()) {
            Product p2 = new Product(2L, "c1d4e7r8d5f2");
            logger.info(String.format("Adding %s", p2));
            pRepo.save(p2);
        }
        if (pRepo.findBySku("c4d4f1v2f5v3").isEmpty()) {
            Product p3 = new Product(3L, "c4d4f1v2f5v3");
            logger.info(String.format("Adding %s", p3));
            pRepo.save(p3);
        }
        if (pRepo.findBySku("v145dc2365sa").isEmpty()) {
            Product p4 = new Product(4L, "v145dc2365sa");
            logger.info(String.format("Adding %s", p4));
            pRepo.save(p4);
        }
        if (pRepo.findBySku("fg54vc14tr78").isEmpty()) {
            Product p5 = new Product(5L, "fg54vc14tr78");
            logger.info(String.format("Adding %s", p5));
            pRepo.save(p5);
        }
        if (pRepo.findBySku("12563dcfvg41").isEmpty()) {
            Product p6 = new Product(6L, "12563dcfvg41");
            logger.info(String.format("Adding %s", p6));
            pRepo.save(p6);
        }
        if (pRepo.findBySku("vcg46578vf32").isEmpty()) {
            Product p7 = new Product(7L, "vcg46578vf32");
            logger.info(String.format("Adding %s", p7));
            pRepo.save(p7);
        }
        if (pRepo.findBySku("vgb576hgb675").isEmpty()) {
            Product p8 = new Product(8L, "vgb576hgb675");
            logger.info(String.format("Adding %s", p8));
            pRepo.save(p8);
        }
        if (pRepo.findBySku("unbjh875ujg7").isEmpty()) {
            Product p9 = new Product(9L, "unbjh875ujg7");
            logger.info(String.format("Adding %s", p9));
            pRepo.save(p9);
        }
        if (pRepo.findBySku("u1f4f5e2d2xw").isEmpty()) {
            Product p10 = new Product(10L, "u1f4f5e2d2xw");
            logger.info(String.format("Adding %s", p10));
            pRepo.save(p10);
        }
        if (pRepo.findBySku("j85jg76jh845").isEmpty()) {
            Product p11 = new Product(11L, "j85jg76jh845");
            logger.info(String.format("Adding %s", p11));
            pRepo.save(p11);
        }
        if (pRepo.findBySku("g4f7e85f4g54").isEmpty()) {
            Product p12 = new Product(12L, "g4f7e85f4g54");
            logger.info(String.format("Adding %s", p12));
            pRepo.save(p12);
        }
    }

    @Transactional
    public void bootstrapReviews() {
        if (rRepo.findById(1L).isEmpty()) {
            Review r1 = new Review(1L, "approved");
            rRepo.save(r1);
            logger.info(String.format("Adding %s", r1));
        }

        if (rRepo.findById(2L).isEmpty()) {
            Review r2 = new Review(2L, "approved");
            rRepo.save(r2);
            logger.info(String.format("Adding %s", r2));
        }

        if (rRepo.findById(3L).isEmpty()) {
            Review r3 = new Review(3L);
            logger.info(String.format("Adding %s", r3));
            rRepo.save(r3);
        }
    }

    public void bootstrapVotes() {

        if (voteRepo.findById("be75ad64-829f-49f7-a077-0faaef6ace75").isEmpty()) {
            User user = userRepo.findByUsername("user1@mail.com").get();
            Review review = rRepo.findById(1L).get();
            Vote vote = new Vote("be75ad64-829f-49f7-a077-0faaef6ace75", "upVote", user, review);

            voteRepo.save(vote);
            logger.info(String.format("Adding %s", vote));
        }

        if (voteRepo.findById("53eeadd4-7e00-4da9-9a0b-03eb7e54ca6c").isEmpty()) {
            User user = userRepo.findByUsername("user2@mail.com").get();
            Review review = rRepo.findById(2L).get();
            Vote vote = new Vote("53eeadd4-7e00-4da9-9a0b-03eb7e54ca6c", "downVote", user, review);

            voteRepo.save(vote);
            logger.info(String.format("Adding %s", vote));
        }

    }
}
