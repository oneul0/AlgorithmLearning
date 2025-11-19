use std::io::{self, BufRead};

fn main() {
    let stdin = io::stdin();
    let mut lines = stdin.lock().lines();

    let n: usize = lines.next().unwrap().unwrap().trim().parse().unwrap();
    let mut pattern: Vec<char> = lines.next().unwrap().unwrap().chars().collect();

    for _ in 1..n {
        let line: Vec<char> = lines.next().unwrap().unwrap().chars().collect();
        for (p, c) in pattern.iter_mut().zip(line.iter()) {
            if *p != *c {
                *p = '?';
            }
        }
    }

    let result: String = pattern.into_iter().collect();
    println!("{}", result);
}
