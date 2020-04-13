(ns rough-cljs.spec
  (:require [clojure.spec.alpha :as s])
  )

(s/def :rough/opts map?)
(s/def :rough/x-y-w-h (s/cat :x number? :y number? :width number? :height number?))
(s/def :rough/coord-pairs (s/coll-of (s/tuple number? number?)))

(s/def :rough/rectangle (s/cat :type #{:rectangle} :params (s/spec :rough/x-y-w-h) :opts (s/? :rough/opts)))
(s/def :rough/circle (s/cat :type #{:circle} :params (s/spec (s/cat :x number? :y number? :radius number?)) :opts (s/? :rough/opts)))
(s/def :rough/line (s/cat :type #{:line} :params (s/spec (s/cat :x1 number? :y1 number? :x2 number? :y2 number?)) :opts (s/? :rough/opts)))
(s/def :rough/ellipse (s/cat :type #{:ellipse} :params (s/spec :rough/x-y-w-h) :opts (s/? :rough/opts)))
(s/def :rough/linearPath (s/cat :type #{:linearPath} :params (s/spec :rough/coord-pairs) :opts (s/? :rough/opts)))
(s/def :rough/polygon (s/cat :type #{:polygon} :params (s/spec :rough/coord-pairs) :opts (s/? :rough/opts)))
(s/def :rough/arc (s/cat :type #{:arc} :params (s/spec (s/cat :x number? :y number? :width number? :height
                                                              :number? :start-angle number? :stop-angle number? :closed? boolean?)) :opts (s/? :rough/opts)))
(s/def :rough/curve (s/cat :type #{:curve} :params (s/spec :rough/coord-pairs) :opts (s/? :rough/opts)))
(s/def :rough/path (s/cat :type #{:path} :params string? :opts (s/? :rough/opts)))

(s/def :rough/primitive
  (s/or
    :rectangle :rough/rectangle
    :circle :rough/circle
    :line :rough/line
    :ellipse :rough/ellipse
    :linearPath :rough/linearPath
    :polygon :rough/polygon
    :arc :rough/arc
    :curve :rough/curve
    :path :rough/path
    ))
(s/def :rough/primitives (s/coll-of :rough/primitive))




