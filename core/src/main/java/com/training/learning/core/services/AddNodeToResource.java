package com.training.learning.core.services;

import javax.jcr.Node;
import javax.jcr.Session;

public interface AddNodeToResource {

   // public void addNode();

    void addNode(Session session, Node node);
}
