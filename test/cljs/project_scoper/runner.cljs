(ns project-scoper.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [project-scoper.core-test]))

(doo-tests 'project-scoper.core-test)
