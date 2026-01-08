<!-- Guidance for AI coding agents working on this repo -->
# Copilot instructions — brave_and_true

This repo is a small Clojure/Leiningen project. Follow these focused, repo-specific conventions and examples to be immediately productive.

- Purpose: minimal sample Clojure code and exercises in `src/` and `test/`.

- Key files:
  - `project.clj`: project metadata, dependencies, AOT config, and `:main` ([project.clj](project.clj)).
  - Main code: [src/ch4/core.clj](src/ch4/core.clj) — contains example functions, top-level evaluation, and prints.
  - Gen-class example: [src/ch4/genclass.clj](src/ch4/genclass.clj) — shows `gen-class` + AOT (`:aot` in `project.clj`).
  - Tests: [test/ch4/core_test.clj](test/ch4/core_test.clj) — uses `clojure.test`; note there are intentionally failing/placeholder assertions.
  - Docs: [doc/intro.md](doc/intro.md) and [README.md](README.md).

- Build & dev commands (Leiningen):
  - Run tests: `lein test` (tests may fail; inspect `test/ch4/core_test.clj`).
  - Start a REPL: `lein repl` or use your editor's CIDER/JACK-IN shortcut (README notes editor keybindings).
  - Build AOT classes: `lein compile` or `lein uberjar` (AOT target: `target/classes`, classes for `ch4.genclass`).

- Project-specific patterns & gotchas:
  - Top-level evaluation: `src/ch4/core.clj` contains top-level expressions (side-effecting `println`, calls like `(square 5)`, and heavy lazy seq mapping with `map` + `Thread/sleep`). Be cautious: editing or loading this namespace may execute work. Prefer loading namespaces in a REPL after reviewing top-level code.
  - Tests contain obvious incorrect assertions (e.g. `(+ 1 1) = 1`) — these are placeholders. Do not auto-fix without confirming intent with the maintainer.
  - `gen-class` + AOT: `src/ch4/genclass.clj` is compiled via `:aot [ch4.genclass]` in `project.clj`. If you change the gen-class signature, update `project.clj` or re-run `lein compile`.
  - Namespaces: standard Clojure layout (src → namespace path). REPL `:repl-options {:init-ns ch4.core}` is set in `project.clj`.

- How to make safe edits (recommended sequence):
  1. Inspect top-level forms in `src/ch4/core.clj` before loading.
 2. Open or run focused tests in `test/ch4/core_test.clj` to understand intended behavior.
 3. Make small function changes and run `lein test` or `lein repl` to verify.

- Examples to reference when coding:
  - Small pure function: `defn square [x] (* x x)` in [src/ch4/core.clj](src/ch4/core.clj).
  - gen-class pattern: `gen-class :name ch4.MyClass ...` in [src/ch4/genclass.clj](src/ch4/genclass.clj).

- When editing tests or fixing failures:
  - Prefer changing test expectations only when you confirm the original intent (these tests are likely illustrative).
  - If you add new tests, follow the `clojure.test` style used in [test/ch4/core_test.clj](test/ch4/core_test.clj).

- Integration points & external deps:
  - Dependencies are declared in `project.clj` (currently `org.clojure/clojure` and `org.clojure/java.jdbc`). Any code touching JDBC should follow the dependency versions there.

- Where to look for more context:
  - Examples and exercises live in `src/ch4/` and `test/ch4/`.
  - Lightweight docs in `doc/intro.md` and notes in `README.md`.

If any section is unclear or you want the conventions extended (committing, formatting, CI), say which area and I will iterate.
