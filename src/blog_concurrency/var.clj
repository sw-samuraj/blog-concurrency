(ns blog-concurrency.var)

; a static Var
(def static-var "static var")

; a dynamic Var
(def ^:dynamic *dynamic-var* "dynamic var")

; rebinding of the dynamic Var is done per-thread
; other threads are not impacted
(def re-binded-var (binding [*dynamic-var* "re-binded var"] *dynamic-var*))

; Vars are global, so the Var created in another thread
; is accessible in the current thread
(future (def future-var "future var"))

;;
;; An example of the dynamic function rebinding
;;
(defn cube [x] (Math/pow x 3))

(defn cube-root [x] (Math/pow x 1/3))

; the function eligible for rebinding
(defn ^:dynamic prettify [x] (Math/round x))

(defn compute [] (prettify (cube-root (cube 42))))

(defn compute-binary [] (binding [prettify #(Integer/toString % 2)] (compute)))
