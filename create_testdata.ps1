$targetDir = 'C:\Users\chsri\eclipse-workspace\AutomationExerciseFramework\src\test\resources\testdata'
New-Item -ItemType Directory -Path $targetDir -Force | Out-Null
$path = Join-Path $targetDir 'TestData.xlsx'

$headers = @('TestCaseID','TestCaseName','Username','Password','ExpectedResult')
$rows = @(
    @('TC001','Login_ValidCredentials','user1@example.com','Password@123','LoginSuccess'),
    @('TC002','Login_InvalidPassword','user1@example.com','wrongPass','LoginFailure'),
    @('TC003','Login_InvalidUsername','unknownuser@example.com','Password@123','LoginFailure'),
    @('TC004','Login_BlankPassword','user2@example.com','','ValidationError'),
    @('TC005','Login_BlankUsername','','somePassword','ValidationError'),
    @('TC006','Login_BothInvalid','invalid.user','badpass','LoginFailure'),
    @('TC007','Login_LockedUser','locked.user@example.com','Password@123','AccountLocked'),
    @('TC008','Login_InvalidUsernameFormat','user_at_example.com','Password@123','ValidationError'),
    @('TC009','Login_EmptyBoth','','','ValidationError'),
    @('TC010','Login_SuccessfulAlternate','user2@example.com','Pass1234!','LoginSuccess')
)

try {
    $excel = New-Object -ComObject Excel.Application
    $excel.Visible = $false
    $excel.DisplayAlerts = $false

    $wb = $excel.Workbooks.Add()
    $ws = $wb.Worksheets.Item(1)
    $ws.Name = 'LoginTestData'

    # Write headers
    for ($c = 0; $c -lt $headers.Length; $c++) {
        $ws.Cells.Item(1, $c + 1).Value2 = $headers[$c]
    }

    # Write rows
    for ($r = 0; $r -lt $rows.Length; $r++) {
        $row = $rows[$r]
        for ($c = 0; $c -lt $row.Length; $c++) {
            $ws.Cells.Item($r + 2, $c + 1).Value2 = $row[$c]
        }
    }

    # Format header: bold and light gray background
    $rangeHeader = $ws.Range("A1","E1")
    $rangeHeader.Font.Bold = $true
    $rangeHeader.Interior.ColorIndex = 15

    # Set column widths
    $ws.Columns.Item(1).ColumnWidth = 14   # TestCaseID
    $ws.Columns.Item(2).ColumnWidth = 36   # TestCaseName
    $ws.Columns.Item(3).ColumnWidth = 30   # Username
    $ws.Columns.Item(4).ColumnWidth = 22   # Password
    $ws.Columns.Item(5).ColumnWidth = 20   # ExpectedResult

    # Freeze top row
    $ws.Application.ActiveWindow.SplitRow = 1
    $ws.Application.ActiveWindow.FreezePanes = $true

    # Save as XLSX (file format 51)
    $xlOpenXMLWorkbook = 51
    $wb.SaveAs($path, $xlOpenXMLWorkbook)

    Write-Output "Created Excel file: $path"
}
catch {
    Write-Error "Failed to create Excel file: $_"
}
finally {
    if ($wb -ne $null) { $wb.Close($false) | Out-Null }
    if ($excel -ne $null) { $excel.Quit() | Out-Null }
    [System.GC]::Collect()
    [System.GC]::WaitForPendingFinalizers()
}
