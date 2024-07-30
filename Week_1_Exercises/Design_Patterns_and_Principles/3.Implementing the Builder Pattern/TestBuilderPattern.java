public class TestBuilderPattern {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("8GB")
                .setStorage("1880GB SSD")
                .build();
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM("16GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .setMotherboard("Asus ROG Strix")
                .setPowerSupply("750W")
                .build();
        System.out.println("Basic Computer Configuration:");
        System.out.println("CPU: " + basicComputer.getCPU());
        System.out.println("RAM: " + basicComputer.getRAM());
        System.out.println("Storage: " + basicComputer.getStorage());

        System.out.println("\nGaming Computer Configuration:");
        System.out.println("CPU: " + gamingComputer.getCPU());
        System.out.println("RAM: " + gamingComputer.getRAM());
        System.out.println("Storage: " + gamingComputer.getStorage());
        System.out.println("GPU: " + gamingComputer.getGPU());
        System.out.println("Motherboard: " + gamingComputer.getMotherboard());
        System.out.println("Power Supply: " + gamingComputer.getPowerSupply());
    }
}
