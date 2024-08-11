class Worker {
  constructor(name, experienceYears, salary, age) {
    this.name = name;
    this.experienceYears = experienceYears;
    this.salary = salary;
    this.age = age;
  }
}

function main() {
  const doby = new Worker("avi", 22, 10000, 42);
  console.log(doby);
}

main();
