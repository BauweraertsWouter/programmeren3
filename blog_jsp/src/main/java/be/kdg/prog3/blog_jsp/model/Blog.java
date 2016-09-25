package be.kdg.prog3.blog_jsp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Blog {
    private final Queue<BlogPost> blogPosts;

    public Blog() {
        this.blogPosts = new ConcurrentLinkedQueue<>();

        ///////////////
        // Test data //
        ///////////////
        this.addBlogPost(new BlogPost("Welkom", "Dit is mijn eerste blog post! ..."));
        this.addBlogPost(new BlogPost("Supermarkt", "Ik ben vandaag naar de supermarkt geweest. Lees er alles over in dit bericht! ..."));
    }

    public List<BlogPost> getBlogPosts() {
        return Collections.unmodifiableList(new ArrayList<>(this.blogPosts));
    }

    public void addBlogPost(final BlogPost blogPost) {
        this.blogPosts.offer(blogPost);
    }
}
