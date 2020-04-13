# Rough-CLJS

A data-driven, reagent-wrapper for [RoughJS](https://roughjs.com/)

This library provides a simple reagent component for RoughJS which is a fun library to create diagrams that look hand-drawn.

See examples below.

# Installation

[![Clojars Project](https://img.shields.io/clojars/v/monoid/rough-cljs.svg)](https://clojars.org/monoid/rough-cljs)

Get it from Clojars: `[monoid/rough-cljs "1.0"]`

If you are using [Shadow-CLJS](http://shadow-cljs.org/), it will download the JavaScript dependency automatically.

Otherwise, add RoughJS via NPM:
`$ npm install -D roughjs`

You will also need reagent 0.10.0 in your project.

# Usage

To use it, require it and add it to your hiccup:

```
(require '[rough-cljs.core :refer [Rough]])

(defn MyComponent []
  [:div [Rough {:svg {:width 200 :height 200}} [[:rectangle [10 10 100 100] {:fill "blue"}]]]
```

> Note: Only changes to the drawing primitives have any effect when re-drawing this component.

All supported primitives like rectangle, circle etc. have been defined via spec.
(see rough-cljs/spec)

Check the docstring of `Rough` for more information.

# Examples

[This way please!](https://rough-cljs.netlify.com/)

# Build

Use shadow-cljs: `$ shadow-cljs watch app`

# Kudos

You guys rock:

- Preet Shihn - Author of [RoughJS](https://roughjs.com/)
- Thomas Heller - for [Shadow-CLJS](http://shadow-cljs.org/). Keeps me sane!
- [Reagent project](https://github.com/reagent-project/reagent) - super powers for React
- And the ClojureScript team of course
