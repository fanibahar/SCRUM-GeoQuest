<%-- 
    Document   : index
    Created on : Apr 22, 2012, 10:43:42 AM
    Author     : Ankit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>GeoCaching</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="CSS/reset.css" type="text/css" media="all">
        <link rel="stylesheet" href="CSS/Style.css" type="text/css" media="all">
    </head>

    <body>
        <!-- header -->
        <header>
            <div class="container">
                <h1><a href="index.jsp">GeoCaching</a></h1>
                <nav>
                    <ul>
                        <li><a href="index.jsp" class="current">Home</a></li>
                        <li><a href="ListTours.jsp">Browse Tours</a></li>
                        <li><a href="createTour.jsp">Create Tour</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                </nav>
            </div>
        </header>
        <div class="main-box">
            <div class="container">
                <div class="inside">
                    <div class="wrapper">
                        <!-- aside -->
                        <aside>
                            <h2>Recent <span>News</span></h2>
                            <!-- .news -->
                            <ul class="news">
                                <li>
                                    <figure><strong>13</strong>April</figure>
                                    <h3><a href="#"></a>First meeting of SCRUM</h3>
                                    It was very interesting meeting.
                                </li>
                                <li>
                                    <figure><strong>16</strong>April</figure>
                                    <h3><a href="#"></a>User Stories</h3>
                                    We managed with 15 user-stories.
                                </li>
                                <li>
                                    <figure><strong>17</strong>April</figure>
                                    <h3><a href="#"></a>Group Name</h3>
                                    Competition between many names.
                                </li>
                                <li>
                                    <figure><strong>19</strong>April</figure>
                                    <h3><a href="#"></a>Second meeting of SCRUM</h3>
                                    Sprint1: User stories and points, Stories selection.
                                </li>
                            </ul>
                            <!-- /.news -->
                        </aside>
                        <!-- content -->
                        <section id="content">
                            <article>
                                <h2>Welcome to <span>GeoCaching!</span></h2>
                                <p></p>
                                <figure><a href="#"><img src="images/Section1.jpg" alt=""></a></figure>
                            </article> 
                        </section>
                    </div>
                </div>
            </div>
        </div>
        <!-- footer -->
        <footer>
            <div class="container">
                <div class="wrapper">
                    <div class="fleft">Copyright - SCRUM 2012</div>
                </div>
            </div>
        </footer>
    </body>
</html>
