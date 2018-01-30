<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 26/01/2018
  Time: 00:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html><html class=''>
<head><script src='//production-assets.codepen.io/assets/editor/live/console_runner-079c09a0e3b9ff743e39ee2d5637b9216b3545af0de366d4b9aad9dc87e26bfd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/events_runner-73716630c22bbc8cff4bd0f07b135f00a0bdc5d14629260c3ec49e5606f98fdd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/css_live_reload_init-2c0dc5167d60a5af3ee189d570b1835129687ea2a61bee3513dee3a50c115a77.js'></script><meta charset='UTF-8'><meta name="robots" content="noindex"><link rel="shortcut icon" type="image/x-icon" href="//production-assets.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" /><link rel="mask-icon" type="" href="//production-assets.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg" color="#111" /><link rel="canonical" href="https://codepen.io/lonekorean/pen/xGLLwX?depth=everything&order=popularity&page=8&q=blog&show_forks=false" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">


    <!DOCTYPE html><html class=''>
    <head><script src='//production-assets.codepen.io/assets/editor/live/console_runner-079c09a0e3b9ff743e39ee2d5637b9216b3545af0de366d4b9aad9dc87e26bfd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/events_runner-73716630c22bbc8cff4bd0f07b135f00a0bdc5d14629260c3ec49e5606f98fdd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/css_live_reload_init-2c0dc5167d60a5af3ee189d570b1835129687ea2a61bee3513dee3a50c115a77.js'></script><meta charset='UTF-8'><meta name="robots" content="noindex"><link rel="shortcut icon" type="image/x-icon" href="//production-assets.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" /><link rel="mask-icon" type="" href="//production-assets.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg" color="#111" /><link rel="canonical" href="https://codepen.io/lonekorean/pen/xGLLwX?depth=everything&order=popularity&page=8&q=blog&show_forks=false" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

        <style class="cp-pen-styles">@import url(https://fonts.googleapis.com/css?family=Roboto:500,700);

        *, *::before, *::after {
            box-sizing: border-box;
        }

        html {
            min-height: 100%;
        }

        body {
            margin: 20px;
            color: #435757;
            background: -webkit-linear-gradient(110deg, #d0b782 20%, #a0cecf 80%);
            background: linear-gradient(-20deg, #d0b782 20%, #a0cecf 80%);
            font: 500 1.2em/1.2 'Roboto', sans-serif;
        }

        .container {
            max-width: 450px;
            margin: 0 auto;
            border-top: 5px solid #435757;
            background-color: rgba(255, 255, 255, .2);
            box-shadow: 0 0 20px rgba(0, 0, 0, .1);
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        h1 {
            margin: 0;
            padding: 20px;
            background-color: rgba(255, 255, 255, .4);
            font-size: 1.8em;
            text-align: center;
        }

        .items {
            display: -webkit-box;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-orient: vertical;
            -webkit-box-direction: normal;
            -ms-flex-direction: column;
            flex-direction: column;
            padding: 20px;
            counter-reset: done-items undone-items;
        }

        h2 {
            position: relative;
            margin: 0;
            padding: 10px 0;
            font-size: 1.2em;
        }

        h2::before {
            content: '';
            display: block;
            position: absolute;
            top: 10px;
            bottom: 10px;
            left: -20px;
            width: 5px;
            background-color: #435757;
        }

        h2::after {
            display: block;
            float: right;
            font-weight: normal;
        }

        .done {
            -webkit-box-ordinal-group: 2;
            -ms-flex-order: 1;
            order: 1;
        }

        .done::after {
            content: ' (' counter(done-items) ')';
        }

        .undone {
            -webkit-box-ordinal-group: 4;
            -ms-flex-order: 3;
            order: 3;
        }

        .undone::after {
            content: ' (' counter(undone-items) ')';
        }

        /* hide inputs offscreen, but at the same vertical positions as the correpsonding labels, so that tabbing scrolls the viewport as expected */
        input {
            display: block;
            height: 53px;
            margin: 0 0 -53px -9999px;
            -webkit-box-ordinal-group: 5;
            -ms-flex-order: 4;
            order: 4;
            outline: none;
            counter-increment: undone-items;
        }

        input:checked {
            -webkit-box-ordinal-group: 3;
            -ms-flex-order: 2;
            order: 2;
            counter-increment: done-items;
        }

        label {
            display: block;
            position: relative;
            padding: 15px 0 15px 45px;
            border-top: 1px dashed #fff;
            -webkit-box-ordinal-group: 5;
            -ms-flex-order: 4;
            order: 4;
            cursor: pointer;
            -webkit-animation: undone .5s;
            animation: undone .5s;
        }

        label::before {
            content: '\f10c'; /* circle outline */
            display: block;
            position: absolute;
            top: 11px;
            left: 10px;
            font: 1.5em 'FontAwesome';
        }

        label:hover, input:focus + label {
            background-color: rgba(255, 255, 255, .2);
        }

        input:checked + label {
            -webkit-box-ordinal-group: 3;
            -ms-flex-order: 2;
            order: 2;
            -webkit-animation: done .5s;
            animation: done .5s;
        }

        input:checked + label::before {
            content: '\f058'; /* circle checkmark */
        }

        @-webkit-keyframes done {
            0% {
                opacity: 0;
                background-color: rgba(255, 255, 255, .4);
                -webkit-transform: translateY(20px);
                transform: translateY(20px);
            }
            50% {
                opacity: 1;
                background-color: rgba(255, 255, 255, .4);
            }
        }

        @keyframes done {
            0% {
                opacity: 0;
                background-color: rgba(255, 255, 255, .4);
                -webkit-transform: translateY(20px);
                transform: translateY(20px);
            }
            50% {
                opacity: 1;
                background-color: rgba(255, 255, 255, .4);
            }
        }

        @-webkit-keyframes undone {
            0% {
                opacity: 0;
                background-color: rgba(255, 255, 255, .4);
                -webkit-transform: translateY(-20px);
                transform: translateY(-20px);
            }
            50% {
                opacity: 1;
                background-color: rgba(255, 255, 255, .4);
            }
        }

        @keyframes undone {
            0% {
                opacity: 0;
                background-color: rgba(255, 255, 255, .4);
                -webkit-transform: translateY(-20px);
                transform: translateY(-20px);
            }
            50% {
                opacity: 1;
                background-color: rgba(255, 255, 255, .4);
            }
        }</style></head><body>
<!--
  Checkbox Trickery with CSS:
  http://codersblock.com/blog/checkbox-trickery-with-css/
-->

<div class="container">
    <h1>Will's Summer To-Do List</h1>
    <div class="items">
        <input id="item1" type="checkbox" checked>
        <label for="item1">Create a to-do list</label>

        <input id="item2" type="checkbox">
        <label for="item2">Take down Christmas tree</label>

        <input id="item3" type="checkbox">
        <label for="item3">Learn Ember.js</label>

        <input id="item4" type="checkbox">
        <label for="item4">Binge watch every episode of MacGyver</label>

        <input id="item5" type="checkbox">
        <label for="item5">Alphabetize everything in the fridge</label>

        <input id="item6" type="checkbox">
        <label for="item6">Do 10 pull-ups without dropping</label>

        <h2 class="done" aria-hidden="true">Done</h2>
        <h2 class="undone" aria-hidden="true">Not Done</h2>
    </div>
</div>

</body></html>

    </html>