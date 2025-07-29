# MultithreadedChatApplication

**COMPANY**: CODTECH IT SOLUTIONS
**NAME**:SAKSHI SWAMI
**INTERN ID**: CT04DH328
**DOMAIN**:JAVA PROGRAMMING
**DURATION**: 4 WEEKS
**MENTOR**: NEELA SANTOSH

## Description ##

 ## A CLIENT-SERVER CHAT APPLICATION USING JAVA SOCKETS AND MULTITHREADING TO HANDLE MULTIPLE USERS 
 : This project is a simple yet functional multi-client chat application built using Java Sockets. It demonstrates a client-server model where multiple clients can connect to a central chat server and exchange real-time messages. The server handles multiple clients using multithreading and broadcasts each message to all connected clients.

# Project Overview
The Java Chat Application consists of two main components:

-Chat Server (ChatServer.java):
The server runs on a specific port (default is 12346) and continuously listens for incoming client connections. Each new client is handled in a separate thread, allowing concurrent messaging. The server receives a message from one client and broadcasts it to all other connected clients.

-Chat Client (ChatClient.java):
The client connects to the server using a socket. It provides two-way communication using separate threads: one for sending user input and one for receiving server responses. This ensures real-time chat flow and a responsive user interface.

# Features
📤 Real-time message broadcasting

🧵 Multithreading for handling multiple clients

🔄 Continuous listening and message relay

🖥️ Console-based user interface

🔐 Graceful handling of client disconnection

# Technologies Used

-Java SE (Standard Edition)

-Java Sockets (java.net)

-Multithreading (java.lang.Thread)

-I/O Streams (java.io)

 # Workflow
-Start the server: java ChatServer

-Open multiple terminals or command prompts.

-In each terminal, run: java ChatClient

-Enter messages from any client and see them broadcast to others.

# Use Cases
-Learning network programming basics in Java

-Understanding sockets and multi-threaded applications

-Creating basic real-time chat systems

# Conclusion
This project is a foundational implementation of a multi-client chat system in Java, showcasing how networking and multithreading can work together to build real-time applications. It serves as an excellent starting point for beginners looking to understand socket programming, thread management, and client-server architecture in Java.
Through this hands-on experience, I gained deeper insight into how real-world chat applications operate behind the scenes — from establishing server connections and handling concurrent users, to broadcasting messages and maintaining seamless communication.

This project not only demonstrates core programming concepts but also strengthens problem-solving skills by dealing with real-time inputs, connection issues, and stream handling. It's simple yet powerful enough to evolve into a full-fledged messaging platform with additional features like GUI, authentication, encryption, and chat rooms.

# Output 
<img width="1298" height="2053" alt="Image" src="https://github.com/user-attachments/assets/a9a06708-07de-4b81-ad15-4a2ec3ff2ca2" />

