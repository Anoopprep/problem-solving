/**
 * 1472. Design Browser History
 * https://leetcode.com/problems/design-browser-history/description/
 */
package List;

class Node {
    String url;
    Node prev, next;

    Node(String url) {
        this.url = url;
        this.prev = this.next = null;
    }
}

class NavigationList {
    Node current;
    int size;

    NavigationList(String homepage) {
        Node newNode = new Node(homepage);
        this.current = newNode;
    }

    public void addAfterCurrent(String url) {
        Node newNode = new Node(url);
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
        return;
    }

    public String moveForward(int step) {
        int count = 0;
        while(count < step && current.next != null) {
            current = current.next;
            count++;
        }
        return current.url;
    }

    public String moveBackward(int step) {
        int count = 0;
        while(count < step && current.prev != null) {
            current = current.prev;
            count++;
        }
        return current.url;
    }
}

class BrowserHistory {
    NavigationList navigationList;
    public BrowserHistory(String homepage) {
        navigationList = new NavigationList(homepage);
    }
    
    public void visit(String url) {
        navigationList.addAfterCurrent(url);
    }
    
    public String back(int steps) {
        return navigationList.moveBackward(steps);
    }
    
    public String forward(int steps) {
        return navigationList.moveForward(steps);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */