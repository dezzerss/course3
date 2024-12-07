
public class Main {
    public static void main(String[] args) {
        // Генерация текстового отчета
        Report textReport = new TextReport();
        System.out.println("Генерация текстового отчета:");
        textReport.generateReport();

        // Генерация графического отчета
        Report chartReport = new ChartReport();
        System.out.println("Генерация графического отчета:");
        chartReport.generateReport();

        // Генерация табличного отчета
        Report tableReport = new TableReport();
        System.out.println("Генерация табличного отчета:");
        tableReport.generateReport();
    }
}

abstract class Report {
    public final void generateReport() {
        collectData();
        analyzeData();
        formatReport();
        printReport();
    }

    protected abstract void collectData();
    protected abstract void analyzeData();
    protected abstract void formatReport();

    protected void printReport() {
        System.out.println("Отчет готов и отправлен на печать.\n");
    }
}

class TextReport extends Report {
    @Override
    protected void collectData() {
        System.out.println("Сбор данных для текстового отчета...");
    }

    @Override
    protected void analyzeData() {
        System.out.println("Анализ данных для текстового отчета...");
    }

    @Override
    protected void formatReport() {
        System.out.println("Форматирование текста для текстового отчета...");
    }
}

class ChartReport extends Report {
    @Override
    protected void collectData() {
        System.out.println("Сбор данных для графического отчета...");
    }

    @Override
    protected void analyzeData() {
        System.out.println("Анализ данных для графического отчета...");
    }

    @Override
    protected void formatReport() {
        System.out.println("Создание графиков для графического отчета...");
    }
}

class TableReport extends Report {
    @Override
    protected void collectData() {
        System.out.println("Сбор данных для табличного отчета...");
    }

    @Override
    protected void analyzeData() {
        System.out.println("Анализ данных для табличного отчета...");
    }

    @Override
    protected void formatReport() {
        System.out.println("Создание таблицы для табличного отчета...");
    }
}