package ca.mcmaster.se2aa4.benchmarker;

import ca.mcmaster.se2aa4.mazerunner.*;
import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class MazeRunnerBenchmarkSmall {

    MazeSolver solver;
    Maze maze;

    @Setup(Level.Invocation)
    public void setUp() throws Exception {
        maze = new Maze("./examples/tiny.maz.txt");
    }

    @Benchmark
    public void testRighthand() {
        solver = new RightHandSolver();
        solver.solve(maze);
    }

    @Benchmark
    public void testTremaux() {
        solver = new TremauxSolver();
        solver.solve(maze);
    }

    @Benchmark
    public void testBFS() {
        solver = new BFSSolver();
        solver.solve(maze);
    }
}