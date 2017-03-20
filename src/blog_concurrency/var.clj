(ns blog-concurrency.var)

(def static-var "static var")

(def ^:dynamic *dynamic-var* "dynamic var")

(def re-binded-var (binding [*dynamic-var* "re-binded var"] *dynamic-var*))

(future (def future-var "future var"))
