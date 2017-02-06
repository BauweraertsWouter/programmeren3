package be.kdg.webapp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Wouter on 6/02/2017.
 */
public class Blog {
    private final Queue<Post> blogPosts;

    public Blog() {
        this.blogPosts = new ConcurrentLinkedQueue<>();
    }

    public List<Post> getBlogPosts() {
        return Collections.unmodifiableList(new ArrayList<>(this.blogPosts));
    }

    public void addBlogPost(final Post blogPost){
        this.blogPosts.offer(blogPost);
    }

    public int getCounter() {
        return blogPosts.size();
    }
}
